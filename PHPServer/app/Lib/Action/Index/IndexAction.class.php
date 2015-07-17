<?php

class IndexAction extends Action{
	public function index(){
		
	}
	
	public function show() { //²éÑ¯×Ö·û´®
		$games = M('game')->select();
		$len =  count($games);
		for($i = 0; $i < $len; $i++) {
			echo "gamesid:";
			echo $games[$i]['gid'];
			echo ",title:";
			echo $games[$i]['title'];
		}
	}
	
	public function search() {
		$search_string = $_POST['searchName'];
		$games = M('game')->select();
		$len = count($games);
		for($i = 0; $i < $len; $i++) {
			if(substr_count($games[$i]['title']) > 0) {
				echo "gid:"
				echo $games[$i]['gid'];
				echo ",title:";
				echo $games[$i]['title'];
			}
		}
	}
	
	
	
}
?>