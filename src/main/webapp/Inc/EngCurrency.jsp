 <%@ page pageEncoding="UTF-8"%>
 
 
 <div class="aa-currency">
	<div class="dropdown">
		<a class="btn dropdown-toggle" href="#" type="button"
			id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
			aria-expanded="true"> <i class="fa fa-dollar"></i><%=request.getAttribute("PageCurrency") %> <span
			class="caret"></span>
		</a>
		<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
		
			<li><a href="Currency?value=Euro"><i class="fa fa-euro"></i>EURO</a></li>
			<li><a href="Currency?value=Rub"><i class="fa fa-rouble"></i>RUB</a></li>
			<li><a href="Currency?value=Usd"><i class="fa fa-dollar"></i>USD</a></li>
			<li><a href="Currency?value=Dram"><i class="fa fa-money"></i>Դրամ</a></li>
			
		</ul>
	</div>
</div>