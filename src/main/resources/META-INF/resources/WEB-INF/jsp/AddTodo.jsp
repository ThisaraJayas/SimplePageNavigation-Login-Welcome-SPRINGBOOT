<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>Add Todo Page</title>
        <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
    </head>
<body>
<div class="container">
    <h1>Enter Todo Details</h1>
    <form:form method="post" modelAttribute="todo">
        <fieldset>
            <form:label path="description" >Description</form:label>
            <form:input type="text" path="description" required="required" />
            <form:errors path="description" cssClass="text-warning"/>
        </fieldset>
        <fieldset>
            <form:label path="targetDate" >Target Date</form:label>
            <form:input type="text" path="targetDate" required="required" />
            <form:errors path="targetDate" cssClass="text-warning"/>
        </fieldset>


        <form:input type="hidden" path="id" />
        <form:input type="hidden" path="done" />
        <input type="submit" class="btn btn-success" value="Submit" />
        <form:errors path="description" cssClass="text-warning"/>
    </form:form>
</div>

</body>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</html>