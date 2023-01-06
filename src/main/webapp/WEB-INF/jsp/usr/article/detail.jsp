<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="ARTICLE DETAIL" />
<%@ include file="../common/head.jsp"%>

<script>
	const params = {};
	params.id = parseInt('${param.id}');
	
	function ArticleDetail__increaseHitCount() {
		
		const localStorageKey = 'article__' + params.id + '__alreadyView';
		
		// 만약 이미 한번 조회수가 증가했다면 다음 조건에서 리턴으로 돌려보내고 밑에 실행 안됨
		if (localStorage.getItem(localStorageKey)) {
			return;
		}
		// 위에 조건을 fulsy(null 등으로)로 통과했다면 여기부터 실행 됨
		// 첫 번째 실행 됐을 때 Key가 set되고 그때 true를 같이 set 해줌으로써 다음번에 같은 값의 Key가 들어오면 true가 되게끔 함 -> 위에 조건문이 true가 되서 return 발동
		localStorage.setItem(localStorageKey, true);
		
		$.get('doIncreaseHitCountRd', {
			id : params.id,
			ajaxMode : 'Y'
		}, function(data){
			$('.article-detail__hit-count').empty().html(data.data1);
		}, 'json');
	}
	
	$(function(){
// 		실전코드
// 		ArticleDetail__increaseHitCount();
		
// 		연습코드
		setTimeout(ArticleDetail__increaseHitCount, 2000);
	})
	
</script>

<section class="mt-8 text-xl">
	<div class="container mx-auto px-3">
		<div class="table-box-type-1">
			<table>
				<colgroup>
					<col width="200" />
				</colgroup>
				
				<tbody>
					<tr>
						<th>번호</th>
						<td><div class="badge">${article.id}</div></td>
					</tr>
					<tr>
						<th>작성날짜</th>
						<td>${article.regDate }</td>
					</tr>
					<tr>
						<th>수정날짜</th>
						<td>${article.updateDate }</td>
					</tr>
					<tr>
						<th>조회수</th>
						<td><span class="badge article-detail__hit-count">${article.hitCount}</span></td>
					</tr>
					<tr>
						<th>추천</th>
						<td>
							<c:if test="${rq.getLoginedMemberId() == 0 }">
								<span class="badge">${article.sumReactionPoint}</span>
							</c:if>
							<c:if test="${rq.getLoginedMemberId() != 0 }">
								<button class="btn btn-xs btn-outline">좋아요 👍</button>
								<span class="badge">좋아요 : ${article.goodReactionPoint}개</span>
								<br />
								<button class="btn btn-xs btn-outline">싫어요 👎</button>
								<span class="badge">싫어요 : ${article.badReactionPoint}개</span>
							</c:if>
						</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td>${article.writerName }</td>
					</tr>
					<tr>
						<th>제목</th>
						<td>${article.title }</td>
					</tr>
					<tr>
						<th>내용</th>
						<td>${article.body }</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="btns mt-2">
			<button class="btn-text-link btn btn-active btn-ghost" type="button" onclick="history.back();">뒤로가기</button>
			<c:if test="${article.actorCanChangeData }">
				<a class="btn-text-link btn btn-active btn-ghost" href="modify?id=${article.id }" >수정</a>
				<a class="btn-text-link btn btn-active btn-ghost" onclick="if(confirm('정말 삭제하시겠습니까?') == false) return false;" href="doDelete?id=${article.id }" >삭제</a>
			</c:if>
		</div>
	</div>
</section>
<%@ include file="../common/foot.jsp"%>