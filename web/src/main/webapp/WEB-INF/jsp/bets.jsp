<%@ include file="/WEB-INF/jsp/include.jsp" %>

<table class="table table-condensed">


    <thead>
    <tr>
        <th>#</th>
        <th>Sport</th>
        <th>League</th>
        <th>Match</th>
        <th>Betting Pick</th>
        <th>Odds</th>
        <th>Status</th>
        <th>Tipster</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="bet"  varStatus="count" items="${betList}">
        <c:forEach var="pick" items="${bet.pickList}">
            <tr>
                <td class="span1"></td>
                <td class="span1">${pick.sport}</td>
                <td class="span2">${pick.league}</td>
                <td class="span2">${pick.match}</td>
                <td class="span3">${pick.bettingPick}</td>
                <td class="span1">${pick.odds}</td>
                <td class="span1">${pick.status}</td>
                <td class="span1"></td></tr>
        </c:forEach>

        <tr style="background-color:#D9EDF7">
            <td class="span1">${count.index + 1}</td>
            <td colspan="4" >&nbsp;&nbsp;&nbsp; <strong>Date:</strong> <fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${bet.date}"/> &nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<strong>Bookmaker:</strong> ${bet.bookMaker}</td>
            <td class="span1"><fmt:formatNumber type="number" maxFractionDigits="2" value="${bet.finalOdds}"/></td>
            <td class="span1">${bet.status}</td>
            <td class="span1">${bet.user}</td></tr>
        </tr>
    </c:forEach>
    </tbody>
</table>