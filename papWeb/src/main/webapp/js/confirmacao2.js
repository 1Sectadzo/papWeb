/**
 * 
 */

function confirmarr(idProj,idFunc){
    //alert(id)
    let resposta = confirm("Confirma a remoção deste funcionario?")
    if(resposta===true){
        //alert(id)
        window.location.href="deleteProjFunc?idProj="+idProj+"&idFunc="+idFunc
    }
}