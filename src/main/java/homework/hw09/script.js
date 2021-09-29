function addRow(id) {
    var tbody = document.getElementById(id).getElementsByTagName("TBODY")[0], sum = 0;

    var fio = document.getElementById('fio').value
    var date = new Date(document.getElementById('date').value)
    var sex = document.getElementById('sex').value
    var now = new Date().getFullYear()

    var row = document.createElement("TR")

    var td1 = document.createElement("TD")
    td1.appendChild(document.createTextNode(fio))
	var td2 = document.createElement("TD")
	td2.appendChild (document.createTextNode(sex))

	var td3 = document.createElement("TD")
	td3.appendChild (document.createTextNode(date.toLocaleDateString()))

	var td4 = document.createElement("TD")
	td3.className= "ages";
	td4.appendChild (document.createTextNode((now - date.getFullYear())))


	row.appendChild(td1);
	row.appendChild(td2);
	row.appendChild(td3);
	row.appendChild(td4);
	tbody.appendChild(row);

    var tr = tbody.getElementsByTagName("tr");
    var len = 0, i = tr.length;

	while(i--) {
        if(tr[i].childNodes[3] != null) {
            if(+tr[i].childNodes[3].innerHTML || +tr[i].childNodes[3].childNodes[0].innerHTML ){
                sum += +tr[i].childNodes[3].innerHTML || +tr[i].childNodes[3].childNodes[0].innerHTML;
                len++;
            }
        }
    }
    document.getElementById("avgAge").innerHTML = Math.round(sum/len);
}