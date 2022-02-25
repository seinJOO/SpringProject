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
			
			if (document.regform.writer.value == '') {
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
	}
</script>

</body>
</html>