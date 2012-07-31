<%@ include file="/WEB-INF/jsp/include.jsp" %>

<%@ attribute name="pickContainer" required="true" %>
<%@ attribute name="index" required="true" %>

<div class="row">
    <div class="span10 well offset1">
        <fieldset>
            <div class="control-group span4">
                <label class="control-label" for="sport${index}">Sport</label>

                <div class="controls">
                    <form:select path="${pickContainer}[${index}].sport" id="sport${index}" class="span2">
                        <form:option value="Football" selected="selected">Football</form:option>
                        <form:option value="Tennis">Tennis</form:option>
                        <form:option value="Basketball">Basketball</form:option>
                        <form:option value="Others">Others</form:option>
                    </form:select>
                </div>
            </div>
            <div class="control-group span4">
                <label class="control-label" for="league${index}">League</label>
                <div class="controls">
                    <form:input path="${pickContainer}[${index}].league" type="text" class="span3" id="league${index}"/>
                    <form:errors path="${pickContainer}[${index}].league" class="help-inline"/>
                </div>
            </div>
            <div class="control-group span4">
                <label class="control-label" for="match{index}">Match</label>
                <div class="controls">
                    <form:input path="${pickContainer}[${index}].match" type="text" class="span3" id="match{index}"/>
                    <form:errors path="${pickContainer}[${index}].match" class="help-inline"/>
                </div>
            </div>
            <div class="control-group span4">
                <label class="control-label" for="bettingPick{index}">Betting Pick</label>
                <div class="controls">
                    <form:input path="${pickContainer}[${index}].bettingPick" type="text" class="span3" id="bettingPick{index}"/>
                    <form:errors path="${pickContainer}[${index}].bettingPick" class="help-inline"/>
                </div>
            </div>
            <div class="control-group span4">
                <label class="control-label" for="odds{index}">Odds</label>
                <div class="controls">
                    <form:input path="${pickContainer}[${index}].odds" type="text" class="span1" id="odds{index}"/>
                    <form:errors path="${pickContainer}[${index}].odds" class="help-inline"/>
                </div>
            </div>
            <div class="control-group span4">
                <label class="control-label" for="matchTime{index}">Match Time</label>
                <div class="controls">
                    <form:input path="${pickContainer}[${index}].matchTime" type="text" class="span3" id="matchTime{index}"/>
                    <form:errors path="${pickContainer}[${index}].matchTime" class="help-inline"/>
                </div>
            </div>
            <div class="span1 offset8">
                <a class="btn jsAddPick" href="#">+</a>
                <a class="btn btn-danger jsRemovePick" href="#">x</a>
            </div>
            <form:hidden path="${pickContainer}[${index}].status" value="IN_PLAY"/>

        </fieldset>
    </div>
</div>
