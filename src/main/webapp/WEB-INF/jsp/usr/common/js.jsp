<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
	let msg = '${msg}'.trim(); //String이 남음
	let historyBack = '${historyBack}' == true; //boolean이 남음
	let replaceUri = '${replaceUri}'.trim();
	
	if(msg){
		alert(msg);
	}
	
	if(historyBack){
		history.back();
	}
	
	if(replaceUri){
		location.replace(replaceUri);
	}
	
</script>