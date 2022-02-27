var i = 1;

function addRow() {

	var ingre = document.getElementById('ingredient');	
	var row = ingre.insertRow(ingre.rows.length - 1);
	
	var cell2 = row.insertCell(1);
	
	var html = '<br><input type="text" id="ingredient" placeholder="재료"><input type="text" id="amount" placeholder="양 입력">';
	
	cell2.innerHTML = html; 
	
	var ingre_row = document.getElementById('ingredient_1');
	
	ingre_row.rowspan=i;
	
	i++;
	
}

function delRow() {
	alert("Hello");
}