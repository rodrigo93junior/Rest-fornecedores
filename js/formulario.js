$('#form-contato').submit(function(){
    var nome = $('#nome');
    var email = $('#email');
    var cnpj = $('#cnpj');
    var descricao = $('#descricao');
    var erro = $('.alert');
    var campo = $('#campo-erro');
  
    // removendo o elemento da tela sempre que tentar submeter o formulario
    erro.addClass('d-none');
    $('.is-invalid').removeClass('is-invalid');
  
    // valida o campo nome
    if (nome.val() == '') {
      erro.removeClass('d-none');
      campo.html('nome'); // nome do campo que não foi preenchido!
      nome.focus();
      nome.addClass('is-invalid');
      return false;
    }
    // valida o campo e-mail
    if (email.val() == '') {
        erro.removeClass('d-none');
        campo.html('e-mail'); // nome do campo que não foi preenchido!
        email.focus();
        email.addClass('is-invalid');
        return false;
      }  
    // valida o campo cnpj
    if (cnpj.val() == '') {
      erro.removeClass('d-none');
      campo.html('e-mail'); // nome do campo que não foi preenchido!
      cnpj.focus();
      cnpj.addClass('is-invalid');
      return false;
    }  
    // valida o campo descricao
    if (descricao.val() == '') {
      erro.removeClass('d-none');
      campo.html('descricao'); // nome do campo que não foi preenchido!
      descricao.focus();
      descricao.addClass('is-invalid');
      return false;
    }  
    
    // se chegar aqui pode enviar os dados!
    return true;
  });