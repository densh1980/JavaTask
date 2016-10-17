
<form action=
      <c:url value="/users"/> method="POST" accept-charset="utf-8">
    <h2>Filter users by :</h2>
    <fieldset title="Filter users by :">
        <div class="field">
            <label for="fn-filter"> First Name:</label>
            <input type="text" name="firstName" value="${userSearchPattern.firstName}" id="fn-filter">
        </div>
        <div class="field">
            <label for="ln-filter">Last Name </label>
            <input type="text" name="lastName" value="${userSearchPattern.lastName}" id="ln-filter">
        </div>
        <div class="field">
            <label for="pn-filter">Phone:</label>
            <input type="text" name="phone" value="${userSearchPattern.phone}" id="pn-filter">
        </div>
        <div class="field">
            <label for="em-filter">Email: </label>
            <input type="text" name="email" value="${userSearchPattern.email}" id="em-filter">
        </div>
    </fieldset>
    <div class="sbm-btn">
        <input type="submit" name="command" value="Filter"/>
    </div>
</form>
