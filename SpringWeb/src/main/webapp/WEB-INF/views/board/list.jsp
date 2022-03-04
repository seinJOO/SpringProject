<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html lang="en">

<head>

</head>

<body id="page-top">
	<!-- Page Wrapper -->

	<%@include file="../include/header.jsp"%>

	<!-- Begin Page Content -->

		<!-- Page Heading -->
		<h1 class="h3 mb-2 text-gray-800">게시판</h1>


		<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">공지사항 샘플 게시판
                    <button type="button" class="btn btn-primary btn-sm float-right" onclick="location.href='register?pageNum=${pageMaker.pageNum}'">글쓰기</button>
                </h6>
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" width="100%" cellspacing="0">
						<thead>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>작성자</th>
								<th>작성일</th>
								<th>수정일</th>
								
							</tr>
						</thead> 
						<tbody>
						<c:forEach var="list" items="${list }" varStatus="num">
							<tr>
								<c:set var="index" value="${ num.index + 1 + (pageMaker.pageNum - 1) * 5}" />
								<td>${ index}</td>
								<td><a href="viewContent?num=${list.num }&&index=${index}&&pageNum=${pageMaker.pageNum}">${list.title }</a></td>
								<td>${list.writer }</td>
								<td>
									<f:formatDate value="${list.regdate }" pattern="yyyy-MM-dd"/> 
								</td>
								<td>
									<f:formatDate value="${list.updatedate }" pattern="yyyy-MM-dd HH:mm:ss"/> 
								</td>
							</tr>
						</c:forEach>							
						</tbody>
						
					</table>
					<!-- 페이징 처리 부분 부트스트랩 참고 -->
					<ul class="pagination justify-content-center">
					<!-- 이전 페이지 활성화 여부 -->
					<!-- 시작 페이지는 startPage가 1,6,11,16,...일 때 활성화 됨(5개씩 출력 기준) => 이전 페이지를 클릭했을 때 startPage-1을 pageNum으로 전달 => endPage + startPage가 다시 연산됨-->
					<c:if test="${pageMaker.prev }">
		                       	<li class="page-item">
									<a class="page-link" href="list?pageNum=${pageMaker.startPage -1 }">Prev</a>
								</li>
					</c:if>				
					<!-- 페이지 번호 활성화 여부 -->
					<c:forEach var="num" begin="${pageMaker.startPage }" end="${pageMaker.endPage }" >
						<!-- pageVO에 있는  -->		
						<li class="page-item ${pageMaker.cri.pageNum == num ? 'active' : '' }" >
						<!-- list 요청으로 페이지 번호를 전달, 자동으로 count=보여질 페이지 수 -->
						<!-- 사용자가 버튼을 클릭 시에 해당 버튼에 해당하는 페이지 번호가 Criteria에 매핑이 됨 -->						
						<a class="page-link" href="list?pageNum=${num }" > ${num } </a></li>
					</c:forEach>
					<!-- 이후 페이지 활성화 여부 -->
					<!-- 끝 페이지는 endPage가 5,10,15,20,...일 때 활성화 됨(5개씩 출력 기준) -->
					<c:if test="${pageMaker.next }">
							    <li class="page-item">
							      <a class="page-link" href="list?pageNum=${pageMaker.endPage +1 }">Next</a>
							    </li>
					</c:if>
				    </ul>
					<!-- 페이징 처리 끝 -->
				</div>
			</div>
		</div>
	<!-- End of Main -->

	<%@ include file="../include/footer.jsp"%>
</body>

</html>
