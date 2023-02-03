<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../layout/header.jsp"%>

<div class="container my-3">
        <div class="container">
            <form>
                <div class="form-group mb-2">
                    <input type="text" name="username" class="form-control" placeholder="Enter username" id="username"
                        value="ssar">
                </div>

                <div class="form-group mb-2">
                    <input type="password" name="password" class="form-control" placeholder="Enter password"
                        id="password" value="1234">
                </div>

                <div class="form-group mb-2">
                    <input type="email" name="email" class="form-control" placeholder="Enter email" id="email"
                        value="ssar@nate.com">
                </div>

                <button type="button" class="btn btn-primary">회원수정</button>
            </form>

        </div>
    </div>

    <script>

    </script>

<%@ include file="../layout/footer.jsp"%>