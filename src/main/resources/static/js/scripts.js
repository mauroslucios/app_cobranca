
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
