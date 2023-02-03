<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../layout/header.jsp"%>

<div class="container my-3">
        <form>
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Enter title" name="title" id="title" value="제목입니다">
            </div>

            <div class="form-group">
                <textarea class="form-control summernote" rows="5" id="content" name="content">
                    내용입니다.
                </textarea>
            </div>
        </form>
        <button type="button" class="btn btn-primary">글수정완료</button>

    </div>

    <script>
        $('.summernote').summernote({
            tabsize: 2,
            height: 400
        });
    </script>
    
<%@ include file="../layout/footer.jsp"%>