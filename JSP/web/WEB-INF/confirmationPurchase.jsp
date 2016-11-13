<%-- 
    Document   : confirmationPurchase
    Created on : Nov 13, 2016, 1:56:29 PM
    Author     : rotal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Confirm Purches</title>
	<link rel="stylesheet" type="text/css" href="<?php echo $ServerRoot;?>/css/dashboard.css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link href='https://fonts.googleapis.com/css?family=Raleway' rel='stylesheet' type='text/css'>
	<script type="text/javascript" src="<?php echo $ServerRoot;?>/javascript/javascript.js"></script>
</head>
<body>
	<div class="container">
		<center>
			<h1 class="logo">
				<span class="sale">Sale</span><span class="project">Project</span>
			</h1>
		</center>
		<div id="userLogOut">	
			<b>Hi, <?php echo $user["username"];?>!</b><br>
			<b><a id="logoutButton" href="<?php logout();?>">logout</a></b>
		</div>
		<ul class="navig">
			<li><a href="<?php RoutingDashboard('getCatalog.php');?>">Catalog</a></li>
			<li><a href="<?php RoutingDashboard('getProduk.php');?>">Your Product</a></li>
			<li><a href="<?php RoutingDashboard('getAddProduct.php');?>">Add Product</a></li>
			<li><a href="<?php RoutingDashboard('getSales.php');?>">Sales</a></li>
			<li><a href="<?php RoutingDashboard('getPurchase.php');?>">Purchases</a></li>
		</ul>
		<h1>Please confirm your purchase</h1>
		<hr>
		<form id="myFormConfirmation_Purchase" action="postConfirmationPurchase.php" method="post">
			<div class="remainder">	
				<span class="product">Product</span>  : <?php echo ($produk['name']);?><br>
				<input id="initialPrice" type="hidden" name="initPrice" value="<?php echo $produk['price'];?>"> 
				<span class="price">Price</span> : IDR <span id="aPrice"><?php echo number_format($produk['price']);?></span><br>
				<span class="qual">Quantity</span> : <input id="quantity" type="number" value="1" name="kuantitas" oninput="countPrice()"> PCS<br>
				<span class="totalprice">Total Price</span> : IDR <span id="totalPrice"><?php echo number_format($produk['price']);?></span><br>
				<span class="del">Delivery To</span> : <br>
			</div>
			<br>

			<div class="confirm"">
				Consignee
				<span id="requiredConfirmPurchaseConsignee" class="tooltip">Required</span><br>
				<input id="consignee" type="text" name="namaPembeli" value="<?php echo $user['fullName'];?>" oninput="inputValid('namaPembeli', 'requiredConfirmPurchaseConsignee')"><br>
				<br>
				
				Full Address
				<span id="requiredConfirmPurchaseFullAddress" class="tooltip">Required</span><br>
				<textarea id="address" name="fullAddress" oninput="inputValid('fullAddress', 'requiredConfirmPurchaseFullAddress')"><?php echo $user['fullAddress'];?></textarea>
				
				Postal Code
				<span id="requiredConfirmPurchasePostalCode" class="tooltip">Required</span><br>
				<input id="postal" type="text" name="postalCode" value="<?php echo $user['postalCode'];?>" oninput="inputValid('postalCode', 'requiredConfirmPurchasePostalCode')"><br>
				<br>
				
				Phone Number
				<span id="requiredConfirmPurchasePhoneNumber" class="tooltip">Required</span>
				<span id="requiredConfirmPurchasePhoneNumberOnly" class="tooltip">Number only</span><br>
				<input id="phone" type="text" name="phoneNumber" value="<?php echo $user['phoneNumber'];?>" onchange="inputNumberValid('phoneNumber', 'requiredConfirmPurchasePhoneNumberOnly')" oninput="inputValid('phoneNumber', 'requiredConfirmPurchasePhoneNumber')"><br>
				<br>
				
				12 Digits Credit Card Number
				<span id="requiredConfirmPurchaseCreditCard" class="tooltip">Required</span>
				<span id="requiredConfirmPurchaseCreditCard12" class="tooltip">Must be consist of 12 digits number</span><br>
				<input id="credit" type="text" name="creditCard" onchange="validationCreditCard()" oninput="inputValid('creditCard', 'requiredConfirmPurchaseCreditCard')">
				<br>
				<br>
				
				3 Digit Card Verification Value
				<span id="requiredConfirmPurchaseDigitCard" class="tooltip">Required</span>
				<span id="requiredConfirmPurchaseDigitCard3" class="tooltip">Must be consist of 3 digits number</span><br>
				<input id="verification" type="text" name="codeVerification" onchange="validationVerification()" oninput="inputValid('codeVerification', 'requiredConfirmPurchaseDigitCard')">
				<br><br>
				<br>
				<input type="hidden" name="idPembeli" value="<?php echo $user['id'];?>">
				<input type="hidden" name="idProduk" value="<?php echo $produk['id'];?>">
				<input type="hidden" name="idPenjual" value="<?php echo $produk['idPenjual'];?>">
				<button id="btnCancel" value="CANCEL" name="action">CANCEL</button>
				<button id="btnConfirm" value="CONFIRM" name="action" onclick="validationConfirmPurchaseButton(event)">CONFIRM</button>
				<div id="myPurchaseModal" class="modal">
					<div class="modal-content">
					    <span class="btnNoModal">no</span>
					    <span class="btnYesModal">yes</span>
					    <p>Do you really want to submit the form?</p>
					</div>

				</div>
			
			</div>
		</form>
	</div>
</body>
</html>