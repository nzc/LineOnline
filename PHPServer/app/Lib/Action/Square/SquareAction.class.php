<?php

class TestAction extends Action{
	public function index(){
		
	}
	
	public function show() {
		$bubbles = M('bubble')->select();
		$len = count($bubbles);
		for($i = 0; $i < $len; $i++) {
			echo "bid:";
			echo $bubbles[$i]['bid'];
			echo ",content:";
			echo $bubbles[$i]['content'];
			echo ",good:";
			echo $bubbles[$i]['good'];
			echo ",commentnumber";
			echo $bubbles[$i]['commentnumber'];
		}
	}
	
	public function like() {
		$condition['bid'] = $_POST['bubbleID'];
		$result = M('bubble')->where($condition)->find();
		$result['good'] = $result['good'] + 1;
		M('bubble')->save($result);
	}
	
	public function unlike() {
		$condition['bid'] = $_POST['bubbleID'];
		$result = M('bubble')->where($condition)->find();
		$result['good'] = $result['good'] - 1;
		M('bubble')->save($result);
	}
	
	public function showComment() {
		$condition['bid'] = $_POST['bubbleID'];
		$comments = M('comment')->where($condition)->select();
		$len = count($comments);
		for($i = 0; $i < $len; $i++) {
			echo "comment:";
			echo $comments[$i]['contment'];
		}
	}
	
	public function BubblePost() {
		$bubble['uid'] = $_POST['userID'];
		$bubble['content'] = $_POST['bubbleContent'];
		$bubble['flag'] = 1;
		M('bubble')->add($bubble);
	}
	
	
	
}
?>