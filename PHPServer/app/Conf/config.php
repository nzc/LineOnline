<?php
return array(
	//'配置项'=>'配置值'
	
	//数据库
	'DB_TYPE'               => 'mysql',     // 数据库类型
	'DB_HOST'               => 'localhost', // 服务器地址
	'DB_NAME'               => 'lineonline',          // 数据库名
	'DB_USER'               => 'root',      // 用户名
	'DB_PWD'                => 'Sixgod1234',          // 密码
	'DB_PORT'               => '',        // 端口
	'DB_PREFIX'             => '',    // 数据库表前缀
	'DB_FIELDTYPE_CHECK'    => false,       // 是否进行字段类型检查
	'DB_FIELDS_CACHE'       => true,        // 启用字段缓存
	'DB_CHARSET'            => 'utf8',      // 数据库编码默认采用utf8
	'DB_SQL_BUILD_CACHE'    => false, // 数据库查询的SQL创建缓存
	'DB_SQL_BUILD_QUEUE'    => 'file',   // SQL缓存队列的缓存方式 支持 file xcache和apc
	'DB_SQL_BUILD_LENGTH'   => 20, // SQL缓存的队列长度
	'DB_SQL_LOG'            => false, // SQL执行日志记录
	
	//'DEFAULT_MODULE'		=> 'Index',		// 默认模块
	//'COOKIE_DOMAIN' => '.srDesign.com',		// cookie的域
);
?>