'use strict';
 
app.factory('cadastroPessoaService', ['$http', '$q', function($http, $q){
 
    return {
         
            list: function() {
                    return $http.get('http://localhost:8080/teste-techne-cadastro-pessoa/rest/cadastro/pessoa')
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        return $q.reject(errResponse);
                                    }
                            );
            },
            show: function(id) {
                return $http.get('http://localhost:8080/teste-techne-cadastro-pessoa/rest/cadastro/pessoa/'+id)
                        .then(
                                function(response){
                                    return response.data;
                                }, 
                                function(errResponse){
                                    return $q.reject(errResponse);
                                }
                        );
            },
             
            create: function(pessoa){
                    return $http.post('http://localhost:8080/teste-techne-cadastro-pessoa/rest/cadastro/pessoa', pessoa)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            update: function(pessoa, id){
                    return $http.put('http://localhost:8080/teste-techne-cadastro-pessoa/rest/cadastro/pessoa/'+id, pessoa)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        return $q.reject(errResponse);
                                    }
                            );
            },             
            'delete': function(id){
                    return $http.delete('http://localhost:8080/teste-techne-cadastro-pessoa/rest/cadastro/pessoa/'+id)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        return $q.reject(errResponse);
                                    }
                            );
            }
         
    };
 
}]);