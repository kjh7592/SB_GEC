<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="Upgrade Standard" />
<%@ include file="../common/head.jsp"%>

<section class="mt-8 text-xl">
	<div class="container mx-auto px-3">
		<form action="doUpgradeStandard" method="POST">
			<div class="table-box-type-1">
				<table>
					<colgroup>
						<col width="30%" />
						<col width="35%" />
						<col width="34%" />
					</colgroup>

					<tbody>
						<tr>
							<th>아이템 부위</th>
							<td>
								<label>
									<input type="radio" name="itemPart" value="왼쪽" checked/>왼쪽 (무기/투구/갑옷)
								</label>
								<br />
<!-- 								&nbsp;&nbsp;&nbsp; -->
								<label>
									<input type="radio"  name="itemPart" value="오른쪽" />오른쪽 (목걸이/반지/신발)
								</label>
<!-- 								<label> -->
<!-- 									<input type="radio" name="itemPart" value="무기" checked/>무기 -->
<!-- 								</label> -->
<!-- 								&nbsp;&nbsp;&nbsp; -->
<!-- 								<label> -->
<!-- 									<input type="radio"  name="itemPart" value="투구" checked/>투구 -->
<!-- 								</label> -->
<!-- 								&nbsp;&nbsp;&nbsp; -->
<!-- 								<label> -->
<!-- 									<input type="radio"  name="itemPart" value="갑옷" checked/>갑옷 -->
<!-- 								</label> -->
<!-- 								&nbsp;&nbsp;&nbsp; -->
<!-- 								<label> -->
<!-- 									<input type="radio"  name="itemPart" value="목걸이" checked/>목걸이 -->
<!-- 								</label> -->
<!-- 								&nbsp;&nbsp;&nbsp; -->
<!-- 								<label> -->
<!-- 									<input type="radio"  name="itemPart" value="반지" checked/>반지 -->
<!-- 								</label> -->
<!-- 								&nbsp;&nbsp;&nbsp; -->
<!-- 								<label> -->
<!-- 									<input type="radio"  name="itemPart" value="신발" checked/>신발 -->
<!-- 								</label> -->
							</td>
							<td>
								<span>결과창</span>
							</td>
						</tr>
						<tr>
							<th>유효옵션 개수</th>
							<td>
								<label>
									<input type="radio" name="count" value="3" checked/>3
								</label>
								&nbsp;&nbsp;&nbsp;
								<label>
									<input type="radio"  name="count" value="4" />4
								</label>
							</td>
							<td rowspan="6">resultData</td>
						</tr>
						<tr>
							<th>변환석 사용 여부</th>
							<td>
								<label>
									<input type="radio"  name="isOpChange" value="true" checked/>No
								</label>
								&nbsp;&nbsp;&nbsp;
								<label>
									<input type="radio" name="isOpChange" value="true" />Yes
								</label>
							</td>
						</tr>
						<tr>
							<th>무효옵 한번 붙었는지 여부</th>
							<td>
								<label>
									<input type="radio"  name="isPlusInValidOp" value="true" checked/>No
								</label>
								&nbsp;&nbsp;&nbsp;
								<label>
									<input type="radio" name="isPlusInValidOp" value="true" />Yes
								</label>
							</td>
						</tr>
						<tr>
							<th>강화단계</th>
							<td>
								<label>
									<input type="radio" name="upgrade" value="0" checked/>0강
								</label>
								&nbsp;&nbsp;&nbsp;
								<label>
									<input type="radio"  name="upgrade" value="3" />3강
								</label>
								&nbsp;&nbsp;&nbsp;
								<label>
									<input type="radio"  name="upgrade" value="6" />6강
								</label>
								<br />
<!-- 								&nbsp;&nbsp;&nbsp; -->
								<label>
									<input type="radio"  name="upgrade" value="9" />9강
								</label>
								&nbsp;&nbsp;&nbsp;
								<label>
									<input type="radio"  name="upgrade" value="12" />12강
								</label>
								&nbsp;&nbsp;&nbsp;
								<label>
									<input type="radio"  name="upgrade" value="15" />15강
								</label>
<!-- 								재련은 더이상 강화할 수 있는 단계가 없기 때문에 단순 점수 계산기에서만 다룰 예정 -->
							</td>
						</tr>
						<tr>
							<th>아이템 등급</th>
							<td>
								<label>
									<input type="radio" name="itemClass" value="영웅" checked/>영웅
								</label>
								&nbsp;&nbsp;&nbsp;
								<label>
									<input type="radio"  name="itemClass" value="전설" />전설
								</label>
							</td>
						</tr>
						
						<tr>
							<th>
								<span>하위옵션 입력</<span>
								<br />
								<span>(수치는 숫자만 입력)</<span>
							</th>
							<td>
<!-- 							count값 받아서 반복문으로 코드 줄일 수 있을 듯(ajax로 처리) -->
								<select name="oT" class="my-1 w-40 text-center">
									<option selected disabled hidden>== 옵션 선택 ==</option>
									<option value="치확">치확</option>
									<option value="치피">치피</option>
									<option value="속도">속도</option>
									<option value="공퍼">공%</option>
									<option value="방퍼">방%</option>
									<option value="생퍼">생%</option>
									<option value="효적">효적</option>
									<option value="효저">효저</option>
								</select>
								<input class="w-20" type="text" name="size" placeholder="숫자 입력" />
								<br />
								<select name="oT" class="my-1 w-40 text-center">
									<option selected disabled hidden>== 옵션 선택 ==</option>
									<option value="치확">치확</option>
									<option value="치피">치피</option>
									<option value="속도">속도</option>
									<option value="공퍼">공%</option>
									<option value="방퍼">방%</option>
									<option value="생퍼">생%</option>
									<option value="효적">효적</option>
									<option value="효저">효저</option>
								</select>
								<input class="w-20" type="text" name="size" placeholder="숫자 입력" />
								<br />
								<select name="oT" class="my-1 w-40 text-center">
									<option selected disabled hidden>== 옵션 선택 ==</option>
									<option value="치확">치확</option>
									<option value="치피">치피</option>
									<option value="속도">속도</option>
									<option value="공퍼">공%</option>
									<option value="방퍼">방%</option>
									<option value="생퍼">생%</option>
									<option value="효적">효적</option>
									<option value="효저">효저</option>
								</select>
								<input class="w-20" type="text" name="size" placeholder="숫자 입력" />
								<c:if test="count == 4">
									<select name="oT" class="my-1 w-40 text-center">
										<option selected disabled hidden>== 옵션 선택 ==</option>
										<option value="치확">치확</option>
										<option value="치피">치피</option>
										<option value="속도">속도</option>
										<option value="공퍼">공%</option>
										<option value="방퍼">방%</option>
										<option value="생퍼">생%</option>
										<option value="효적">효적</option>
										<option value="효저">효저</option>
									</select>
									<input class="w-20" type="text" name="size" placeholder="숫자 입력" />
								</c:if>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</form>
		<div class="btns">
			<button class="btn-text-link" type="button" onclick="history.back();">뒤로가기</button>
		</div>
	</div>
</section>
<%@ include file="../common/foot.jsp"%>