<%@ include file="/WEB-INF/jsp/include.jsp" %>

<form:form class="form-horizontal" name="betForm" id="betForm" commandName="bet"  method="post" action="${pageContext.request.contextPath}/bets/betForm">
        <div class="row">
        <h2>
            <div class="span4 offset1">Place a bet</div>
        </h2>

        <div class="pull-right">
            <button type="submit" class="btn btn-primary btn-large">Save</button>
            <button class="btn btn-large">Cancel</button>
        </div>

        <div class="span10 offset1">
            Multiple picks on same bet are allowed
        </div>
        <div class="span10 offset1">&nbsp</div>

    </div>

    <%--bet header--%>
    <div class="row">
        <div class="span10 well offset1">
            <fieldset>
                <div class="control-group span4">
                    <label class="control-label" for="bookMaker">Bookmaker</label>

                    <div class="controls">
                        <form:select path="bookMaker" id="bookMaker" class="span2">
                            <form:option value="bet365">bet365</form:option>
                            <form:option value="betfair">betfair</form:option>
                            <form:option value="UNIBET">UNIBET</form:option>
                            <form:option value="bet-at-home.com">bet-at-home.com</form:option>
                            <form:option value="bwin">bwin</form:option>
                            <form:option value="gamebookers.com">gamebookers.com</form:option>
                            <form:option value="others">others</form:option>
                        </form:select>
                    </div>
                </div>
                <div class="control-group span4">
                    <label class="control-label" for="stake">Stake</label>

                    <div class="controls">
                        <form:select path="stake" id="stake" class="span1">
                            <form:option value="1">1</form:option>
                            <form:option value="2">2</form:option>
                            <form:option value="3">3</form:option>
                            <form:option value="4">4</form:option>
                            <form:option value="5">5</form:option>
                            <form:option value="6">6</form:option>
                            <form:option value="7">7</form:option>
                            <form:option value="8">8</form:option>
                            <form:option value="9">9</form:option>
                            <form:option value="10">10</form:option>
                        </form:select>
                    </div>
                </div>
                <div class="span1">
                    <a class="btn jsAddPick" href="#" id="jsHeaderAddPick">+</a>
                </div>
            </fieldset>
        </div>
    </div><%--bet header--%>

   <%--<c:out value="${fn:length(bet.pickList)}"/>--%>
   <c:forEach var="pick"  varStatus="count" items="${bet.pickList}">
       <%--<c:out value="${bet.pickList[count.index].league}"/>
       <c:out value="${count.index}"/>--%>
       <threewaypicks:pickForm pickContainer="pickList" index="${count.index}"/>
   </c:forEach>

</form:form>

<script type="text/javascript">
    betForm = {};
    betForm.pickIndex=${fn:length(bet.pickList)};

    betForm.getPickTag = function(index,addButton){
        $.get('${pageContext.request.contextPath}/bets/pickFormTag/'+index, function(data){
            betForm.addPickToDom(addButton,data);
            console.log('pick added');
        });
    };

    betForm.addPickToDom = function( addButton, pickHtml ){
        addButton.parent().parent().parent().parent().parent().append(pickHtml);
    }

    $(document).ready(function(){
        if (betForm.pickIndex == 0 ){
            $('#jsHeaderAddPick').click();
        }
    });

    $('.jsAddPick').live('click', function(){
        betForm.getPickTag(betForm.pickIndex,$(this));
        betForm.pickIndex++;
    });

    $('.jsRemovePick').live('click', function(){
       $(this).parent().parent().parent().parent().remove();
       console.log('pick removed');
    });
</script>

