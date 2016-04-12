<html>
<head>
<title>Duncan's Just-In-Time Donuts</title>
<link rel="stylesheet" type="text/css" href="donuts.css" />
<script type="text/javascript">
function updateOrder() {
const TAXRATE;
const DONUTPRICE;
var numCakeDonuts = document.getElementById("cakedonuts").value;
var numGlazedDonuts = document.getElementById("glazeddonuts").value;
var subTotal = (numCakeDonuts + numGlazedDonuts) * DONUTPRICE;
var tax = subTotal * TAXRATE;
var total = subTotal + tax;
}
function placeOrder() {
// Submit order to server...
form.submit();
}
</script>
</head>
<body>
<div id="frame">
...
<form name="orderform" action="donuts.php" method="POST">
...
<div class="field">
# of cake donuts: <input type="text" id="cakedonuts" name="cakedonuts"
value="" onchange="updateOrder();" />
</div>
<div class="field">
# of glazed donuts: <input type="text" id="glazeddonuts"
name="glazeddonuts" value="" onchange="updateOrder();" />
</div>
...
<div class="field">
<input type="button" value="Place Order"
onclick="placeOrder(this.form);" />
</div>
</form>
</div>
</body>