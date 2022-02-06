// Initialize tooltip component
$(function() {
	$('[data-toggle="tooltip"]').tooltip()
})
// Initialize popover component
$(function() {
	$('[data-toggle="popover"]').popover()
})
setTimeout(function() {
	// Closing the alert
	$('.alert').alert('close');
}, 5000);
$(document).ready(function() {
	$('#btnDelete').click(function() {
		document.getElementById('formDelete').submit();
	})
});
$('#myModal').on('show.bs.modal', function(event){
		var button = $(event.relatedTarget);
		
		var codigoTitulo = button.data('codigo');
		var descricaoTitulo = button.data('descricao');
		
		var modal = $(this);
		var form = modal.find('form');
		var action = form.attr('action');
		if(!action.endsWith('/')){
			action += '/';
		}
		form.attr('action', action + codigoTitulo);
		
		modal.find('.modal-body span').html('Tem certeza que deseja excluir o título <strong> ' + descricaoTitulo + '</strong>?');
		
		
		
});
