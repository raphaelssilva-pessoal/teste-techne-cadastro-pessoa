'use strict';
app.controller("cadastroPessoaCtrl", function($scope, $http, $location, cadastroPessoaService) {
	var self = this;
	self.pessoa={id:null,nome:'',idade:'',cpf:''};
    self.pessoas=[];
    self.listPessoa = function(){
    	cadastroPessoaService.list()
            .then(
                         function(d) {
                              self.pessoas = d;
                         },
                          function(errResponse){
                              console.error('Erro ao listar usuario');
                          }
                 );
    };
      
    self.createPessoa = function(pessoa){
    	cadastroPessoaService.create(pessoa)
                .then(
                self.listPessoa, 
                        function(errResponse){
                             console.error('Erro ao criar pessoa.');
                        } 
            );
    };

   self.updatePessoa = function(pessoa, id){
	   cadastroPessoaService.update(pessoa, id)
                .then(
                        self.listPessoa, 
                        function(errResponse){
                             console.error('Erro ao atualizar pessoa.');
                        } 
            );
    };

   self.deletePessoa = function(id){
	   cadastroPessoaService.delete(id)
                .then(
                        self.listPessoa, 
                        function(errResponse){
                             console.error('Erro ao deletar pessoa.');
                        } 
            );
    };
    
    self.showPessoa = function(id){
 	   cadastroPessoaService.show(id)
                 .then(
                		 function(d) {
                			 console.log(d)
                             self.pessoa = d;
                        }, 
                         function(errResponse){
                              console.error('Erro ao deletar pessoa.');
                         } 
             );
     };

    self.listPessoa();

    self.submit = function() {
        if(self.pessoa.id===null){
            console.log('Salvando pessoa', self.pessoa);    
            self.createPessoa(self.pessoa);
        }else{
            self.updatePessoa(self.pessoa, self.pessoa.id);
            console.log('Editando com id', self.pessoa.id);
        }
        $location.path('/')
    };
         
    self.edit = function(id){    	
    	self.showPessoa(id)    
    	console.log(self.pessoa)    	
    	self.showPessoa(id)   
    	$location.path('/edit/'+id)
    };
         
    self.remove = function(id){
        if(self.pessoa.id === id) {//clean form if the user to be deleted is shown there.
           self.reset();
        }
        self.deletePessoa(id);
    };

     
    self.reset = function(){
        self.pessoa={id:null,nome:'',idade:'',cpf:''};
    };
})