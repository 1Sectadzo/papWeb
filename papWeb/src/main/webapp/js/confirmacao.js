/**
 *
 */
//alert("Teste")
function confirmar(id){
    //alert(id)
    let resposta = confirm("Confirma a exclusão deste funcionario?")
    if(resposta===true){
        //alert(id)
        window.location.href="deleteFunc?id="+id
    }
   
}
