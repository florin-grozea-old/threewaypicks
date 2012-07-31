<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<div class="row">
    <div class="span10 well offset1">
        <fieldset>
            <div class="control-group span4">
                <label class="control-label" for="sport">Sport</label>

                <div class="controls">
                    <form:select path="bet.pickList[${index}].sport" id="sport" class="span2">
                        <form:option value="Football" selected="selected">Football</form:option>
                        <form:option value="Tennis">Tennis</form:option>
                        <form:option value="Basketball">Basketball</form:option>
                        <form:option value="Others">Others</form:option>
                    </form:select>
                </div>
            </div>
            <div class="control-group span4">
                <label class="control-label" for="league">League</label>
                <div class="controls">
                    <form:input path="bet.pickList[${index}].league" type="text" class="span3" id="league"/>
                </div>
            </div>
            <div class="control-group span4">
                <label class="control-label" for="match">Match</label>
                <div class="controls">
                    <form:input path="bet.pickList[${index}].match" type="text" class="span3" id="match"/>
                </div>
            </div>
            <div class="control-group span4">
                <label class="control-label" for="bettingPick">Betting Pick</label>
                <div class="controls">
                    <form:input path="bet.pickList[${index}].bettingPick" type="text" class="span3" id="bettingPick"/>
                </div>
            </div>
            <div class="control-group span2">
                <label class="control-label" for="odds">Odds</label>
                <div class="controls">
                    <form:input path="bet.pickList[${index}].odds" type="text" class="span1" id="odds"/>
                </div>
            </div>
            <div class="control-group span4 offset2">
                <label class="control-label" for="matchTime">Match Time</label>
                <div class="controls">
                    <form:input path="bet.pickList[${index}].matchTime" type="text" class="span3" id="matchTime"/>
                </div>
            </div>
            <div class="span1 offset8">
                <a class="btn jsAddPick" href="#">+</a>
                <a class="btn btn-danger jsRemovePick" href="#">x</a>
            </div>

        </fieldset>
    </div>
</div>