<?php

class BookAction extends Action{
	public function index(){
		$time = date('Y-m-d H:i:s',time());
		echo $time,"</br>";
		$d = strtotime($time)+1800;
		
		echo $d-strtotime($time);
	}
	
	public function show() {
		$pgid = $_GET['playgroundID'];
		$cond['pgid'] = $pgid;
		$cond['flag'] = 1;
		$games = M('game')->where($cond)->select();
		$len =  count($games);
		$result = array();
		for($i = 0; $i < $len; $i++) {
			$tmp['gameid'] = $games[$i]['gid'];
			$tmp['title'] = $games[$i]['title'];
			$tmp['photo'] = $games[$i]['photo'];
			$tmp['caution'] = $games[$i]['caution'];
			$condition['gid'] = $games[$i]['gid'];
			list($date,$time)=split(" ",date('Y-m-d H:i:s',time()));
			
			$gamevectors = M('gamevector')->where($condition)->select();
			$count = 3;
			$timeterval = array();
			for( $j = 0; $j < count($gamevectors); $j++) {
				if($count == 0)
					break;
				if($time < $gamevectors[$j]['endtime']) {
					$t['starttime'] =  $gamevectors[$j]['starttime'];
					$t['endtime'] = $gamevectors[$j]['endtime'];
					$tim = date('Y-m-d H:i:s',time());
					list($date,$tim) = split(" ",$tim);
					$c['starttime'] = $date." ".$t['starttime'].":00";
					$c['gid'] = $condition['gid'];
					$c['flag'] = 1;
					$ap = M('appointment')->where($c)->select();
					$tlen = count($ap);
					
					$t['number'] = $gamevectors[$j]['number'] - $tlen;
					array_push($timeterval,$t);
					$count--;
					
				}
			}
			$tmp['timeterval'] =  $timeterval;
			array_push($result,$tmp);
		}
		
		echo json_encode($result);
	}
	
	public function select() {
		$condition['gid'] = $_GET['attractionID'];
		$condition['flag'] = 1;
		$result = M('game')->where($condition)->find();
		$result['timeterval'] =  M('gamevector')->where($condition)->select();
		echo json_encode($result);
	}
	
	public function book() {
		$appointment['uid'] = $_POST['userID'];
		$appointment['gid'] = $_POST['gameID'];
		$appointment['starttime'] = $_POST['startTime'];
		$appointment['endtime'] = $_POST['endTime'];
		$appointment['flag'] = 1;
		if($appointment['uid']=="" || $appointment['gid'] == "" || 	$appointment['starttime'] == "" || 		$appointment['endtime'] == "") {
			echo "userID, gameID, startTime, endTime is empty";
			return;
		}
		$condition['gid'] = $appointment['gid'];
		$condition['flag'] = 1;
		$ap = M('appointment')->where($condition)->select();
		$tlen = count($ap);
		list($date,$tim) = split(" ",$appointment['starttime']);
		list($h,$i,$s) = split(':',$tim);
		$condition['starttime']= $h.':'.$i;
		$tmp = M('gamevector')->where($condition)->find();
		$max = $tmp['number'];
		$cond['uid'] = $appointment['uid'];
		$cond['flag'] = 1;
		$aps = M('appointment')->where($cond)->select();
		$ttlen = count($aps);
		if($max > $tlen && $ttlen <= 3) {
			M('appointment')->add($appointment);
			echo "true";
		} else if($max <= $tlen){
			echo "对不起哦亲~ 这个时间段已经被预约满了T T";
		}else {
			echo "您已经预约了三个项目啦~玩了再预约吧亲~";
		}
		
	}
}
?>