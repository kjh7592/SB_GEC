<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${pageTitle}</title>
<!-- 테일윈드 불러오기 -->
<!-- 노말라이즈, 라이브러리 -->
<script src="https://unpkg.com/tailwindcss-jit-cdn"></script>
<!-- 제이쿼리 불러오기 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<!-- 폰트어썸 불러오기 -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" />
<!-- 커스텀 공통 CSS -->
<link rel="stylesheet" href="/resource/common.css" />
</head>
<body>
		<header>
				<div class="h-20 flex container mx-auto text-2xl">
					<a class="h-full px-3 flex items-center" href="#" ><span>로고</span></a>
					<div class="flex-grow"></div>
					<ul class="flex">
						<li class="hover:underline"><a href="/" class="h-full px-3 flex items-center"><span>HOME</span></a></li>
						<li class="hover:underline"><a href="/usr/standard/UpgradeStandard" class="h-full px-3 flex items-center"><span>UPGRADE-STANDARD</span></a></li>
						<li class="hover:underline"><a href="/" class="h-full px-3 flex items-center"><span>CALC</span></a></li>
						<li class="hover:underline"><a href="/usr/article/list" class="h-full px-3 flex items-center"><span>LIST</span></a></li>
						<c:if test="${rq.getLoginedMemberId() == 0 }">
							<li class="hover:underline"><a href="/usr/member/login" class="h-full px-3 flex items-center"><span>LOGIN</span></a></li>
						</c:if>
						<c:if test="${rq.getLoginedMemberId() != 0 }">
							<li class="hover:underline"><a href="/usr/member/doLogout" class="h-full px-3 flex items-center"><span>LOGOUT</span></a></li>
						</c:if>
					</ul>
				</div>
		</header>

		<section class="my-3 text-2xl">
				<div class="container mx-auto px-3">
					<h1>${pageTitle}&nbsp;Page</h1>
				</div>
		</section>
		<main>