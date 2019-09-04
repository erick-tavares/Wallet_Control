fuction exibeContato(){
	var elNome = document.getElementById('txtNome');
	var StrNome = elNome.nodeValue;
	var elDisplay = document.getElementById("display");
	elDisplay.innerText = StrNome;
}

fuction novoContato(){
	var elListaContato = document.getElementById("listaContatos");
	var inputContato = document.createElement("input");

	var labelContato = document.createElement("label");
	labelContato.innerText="Contato";

	var br = document.createElement("br");

	var btExec = document.createElement("input");
		btExec.setAttribute("type", "button");
		btExec.setAttribute("value","-");
		btExec.onclick=function(){
			elListaContato.removeChild(divLinha);
		}

	var divLinha = document.createElement("div");
		divLinha.appendChild("labelContato");
		divLinha.appendChild("inputContato");
		divLinha.appendChild("br");

		elListaContato.appendChild(divLinha);

}
