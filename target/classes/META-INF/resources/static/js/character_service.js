'use strict';

app.factory('RESTService', [ '$http', '$q', function($http, $q) {
	return {
		fetchAllMonster : function() {
			return $http.get('http://localhost:8080/monster')
				.then(function(response) {
					return response.data;
				},
					function(errResponse) {
						console.error('Error while fetching characters');
						return $q.reject(errResponse);
					}
			);
		},
		//More functions that perform CRUD operations ...
		featchPlayer : function() {
			return $http.get('http://localhost:8080/player')
				.then(function(response) {
					return response.data;
				},
					function(errResponse) {
						console.error('Error while fetching characters');
						return $q.reject(errResponse);
					}
			);
		},

		battle : function(id) {
			console.log("HERE IS BATTLE FUNCTION FROM SERVICE"+"||id:"+id);
			return $http({
				method : 'POST',
				url : 'http://localhost:8080/player/0/battleMonster/'+id
			}).then(function(response) {
				//console.log("Response data from service"+response.data);
				return response.data;
			},
				function(errResponse) {
					//console.log("errResponse from service:"+errResponse);
					console.error('Error while fetching characters');
					return $q.reject(errResponse);
				}
			);
		},
		
		editPlayer : function(id,player) {
			//console.log("HERE IS EDIT PLAYER FUNCTION FROM SERVICE"+"||id:"+id+"||player:"+player);
			return $http({
				method : 'PUT',
				url : 'http://localhost:8080/updatePlayer/'+id,
				data : player,
				headers : {'Content-Type' : 'application/json'}
			}).then(function(response) {
				return response.data;
			},
				function(errResponse) {
					console.log(errResponse);
					console.error('Error while fetching characters');
					return $q.reject(errResponse);
				}
			);
		},
		
		createMonster : function(monster) {
			console.log("MONSTER FROM SERVICE"+monster);
			return $http({
				method : 'POST',
				url : 'http://localhost:8080/createMonster',
				data : monster,
				headers : {'Content-Type' : 'application/json'}
			}).then(function(response) {
				return response.data;
			},
				function(errResponse) {
					return $q.reject(errResponse);
				}
			);
		},
		
		deleteMonster : function(id) {
			return $http({
				method : 'DELETE',
				url : 'http://localhost:8080/delete/'+id
			}).then(function(response) {
				return response.data;
			},
				function(errResponse) {
					return $q.reject(errResponse);
				}
			);
		},
	};
} ]);