<?php
//总配置文件

define('CHARSET', 'utf-8');

//项目域名
define('ROOT_DOMAIN', 'http://115.28.84.22/lineonline');
define('APP_DOMAIN', 'http://115.28.84.22/lineonline/app');
define('STATIC_DOMAIN', 'http://115.28.84.22/lineonline/Public');

//项目根目录
define('ROOT_PATH', dirname(__FILE__) . '/../');


//静态页目录配置
define('STATIC_PATH',ROOT_PATH . 'Public/');
define('UPLOAD_PATH',STATIC_PATH . 'upload/');
define('JS_PATH', STATIC_DOMAIN . '/js/');
define('CSS_PATH', STATIC_DOMAIN . '/css/');
define('IMAGES_PATH', STATIC_DOMAIN . '/images/');
define('__PACKAGE__', STATIC_DOMAIN . '/packages/');
?>