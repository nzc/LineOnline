<?php

class IndexAction extends Action{
	public function index(){
		
	}
	
	public function show() { //²éÑ¯×Ö·û´®
		$playgrounds = M('playground')->select();
		
		echo json_encode($playgrounds);
	}
	
	public function search() {
		$search_string = $_POST['searchName'];
		//echo $search_string;
		$games = M('playground')->select();
		$len = count($games);
		$result=array();
		for($i = 0; $i < $len; $i++) {
			//echo $games[$i]['name'];
			if(substr_count($games[$i]['name'],$search_string) > 0) {
				
				array_push($result,$games[$i]);
			}
		}
		echo json_encode($result);
	}
	
	public function signIn() {
		$condition['username'] = $_POST['userName'];
		$condition['password'] = $_POST['password'];
		if($condition['username']=="" || $condition['password']=="") {
			echo "Exception:userName or password is empty";
			return;
		}
		$user = M('user')->where($condition)->find();
		
		if($user) {
			echo "True ";
			echo $user['uid'];
		}
		else {
			echo "Exception:username and password don't match";
		}
	}
	
	public function signUp() {
		$username = $_POST['userName'];
		$password = $_POST['password'];
		$email = $_POST['userEmail'];
		if($username =="" || $password=="") {
			echo "Exception:userName , email or password is empty";
			return;
		}
		$condition['username'] = $username;
		$user = M('user')->where($condition)->find();
		if($user) {
			echo "Exception:username is used";
			return;
		}
		$usr['username'] = $username;
		$usr['password'] = $password;
		$usr['email'] = $email;
		$usr['flag'] = 1;
		M('user')->add($usr);
		echo "True ";
		$usr  = M('user')->where($usr)->find();
		echo $usr['uid'];
	}
}
?>