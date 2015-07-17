<?php

class BookAction extends Action{
	public function index(){
		$datetime = date('y-m-d h:i:s',time());
		list($date,$time) = split(" ",$datetime);
		echo $time;
		
	}
	
	public function show() {
		$games = M('game')->select();
		$len =  count($games);
		for($i = 0; $i < $len; $i++) {
			echo "gamesid:";
			echo $games[$i]['gid'];
			echo ",title:";
			echo $games[$i]['title'];
			$condition['gid'] = $games[$i]['gid'];
			M('gamevector')->where($condition)->select();
		}
	}
	
	public function select() {
		$condition['gid'] = $_POST['attractionID'];
		$result = M('game')->where($condition)->find();
		echo "introduction:";
		echo $result['introduction'];
	}
	
	public function book() {
		$appointment['uid'] = $_POST['userID'];
		$appointment['gid'] = $_POST['gameID'];
		$appointment['starttime'] = $_POST['startTime'];
		$appointment['endtime'] = $_POST['endTime'];
		$appoinment['flag'] = 1;
		if($appointment['uid']=="" || $appointment['gid'] == "" || 	$appointment['starttime'] == "" || 		$appointment['endtime'] == "") {
			echo false;
			return;
		}
		M('appointment')->add($appointment);
		echo true;
		
	}
}
?>