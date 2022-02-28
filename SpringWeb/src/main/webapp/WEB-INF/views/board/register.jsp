<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ include file="../include/header.jsp" %>

<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">Board Register</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
  <div class="col-lg-12">
    <div class="card">
      <div class="card-header bg-primary text-white">게시글 등록</div>
      <div class="card-body">

        <form role="form" action="boardForm" method="post" id="regform" name="regform">
          <div class="form-group">
            <label>작성자</label>
            <input class="form-control" name="writer" id="writer">
          </div>
          <div class="form-group">
            <label>제목</label>
            <input class="form-control" name="title" id="title">
          </div>
          <div class="form-group">
            <label>내용</label>
            <textarea class="form-control" rows="5" name="content" id="content"></textarea>
          </div>
          <input type="hidden" name="pageNum" value="${cri.pageNum }">
          <button type="button" class="btn btn-primary" onclick="regCheck('regist')">등록</button>
          <button type="button" class="btn btn-primary" onclick="regCheck('cancel')">취소</button>
        </form>
      </div>
      <!--  end card-body -->
    </div>
    <!--  end card-body -->
  </div>
  <!-- end card -->
</div>
<!-- /.row -->
<%@ include file="../include/footer.jsp" %>
<script type="text/javascript">	
	function regCheck(e) {
/*  	등록 클릭 시 title, content, writer 값을 검증 처리하는 스크립트
		취소 시 cri.pageNum과 cri.count 값을 전달하여 처리하기
		$("#아이디") HTML속성에 한번에 접근... val(아이디) => 해당 아이디의 값에 접근하는 함수
		*스크립트를 이용하여 등록 값 검증과, 페이지 정보 전달 처리 => 모델 창을 생성하여 그것을 이용한 정보 처리 구성하기 => 세션,,, 
 */
	
		if (e == 'regist') {
			
			if ($("#writer").val() == '') { 
				// $("#아이디") -> HTML의 아이디 속성에 한번에 접근
				// VAL() 함수는 해당 아이디의 값에 접근
				$("#myModal").modal("show"); // 모달 창 보여지게 하기($("모달창id").modal("함수");)
			
			} else if (document.regform.title.value == '') {
				alert("제목을 입력해주세요!");
				return;
			} else if (document.regform.content.value == '') {
				alert("내용을 입력해주세요!");
				return;		
			} else if (confirm("글을 등록하시겠습니까?")) {
				document.regform.submit();
			} 
		} else if (e == 'cancel') {
			if (confirm("글 등록을 취소하시겠습니까?")) {
				$("#regform").attr("action","list");
				$("#regform").submit();
			}
		}
/*		
if (e == 'regist') {			
	if ($("#writer").val() == '') { 				
			alert("작성자를 입력해주세요!");
			return;
		} else if (document.regform.title.value == '') {
			alert("제목을 입력해주세요!");
			return;
		} else if (document.regform.content.value == '') {
			alert("내용을 입력해주세요!");
			return;		
		} else if (confirm("글을 등록하시겠습니까?")) {
			document.regform.submit();
		} 
	} else if (e == 'cancel') {
		if (confirm("글 등록을 취소하시겠습니까?")) {
			$("#regform").attr("action","list");
			$("#regform").submit();
		}
	}
*/
}
</script>

<!-- 모달 창 만들기 !!! 화면에 미리 만들어놓고 호출하는 방식 사용
	  모달 창 - 창의 형태이지만, 같은 레이아웃 안에서 보이게 함(새 창 X - 팝업 차단 기능과 충돌하지 않음)
	 이벤트 발생 시 다양한 용도로 활용, DB와 관련된 기능을 제외한 대부분의 값 표시 가능
	 모달 창 실행 시 부모 창이 멈추게 됨 - 닫기 등으로 종료를 시켜야 부모 창 활성화 가능
	 id를 지정 -> 자바스크립트를 통해 model("show")라는 함수로 화면에 보여지도록 처리 -->
	
<div class="modal fade" id="myModal">
	<div class="modal-dialog">
		<div class="modal-content">
		<!-- Modal Header -->
		<div class="modal-header">
			<h4 class="modal-title">Modal Heading</h4>
			<button type="button" class="close" data-dismiss="modal">&times;</button>
		</div>
		<!-- Modal body -->
		<div class="modal-body">작성자, 제목은 필수 사항입니다.</div>
		<!-- Modal footer -->
		<div class="modal-footer">
			<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
		</div>
		</div>
	</div>
</div>

</body>
</html>