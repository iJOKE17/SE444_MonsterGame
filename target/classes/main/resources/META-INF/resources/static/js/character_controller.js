'use strict';

app.controller('CharacterController', [
	'$scope',
	'RESTService',
	function($scope, RESTService) {
		var self = this;

		self.displayWinner = {
			id : '',
			name : null,
			level : '',
			experience : '',
			health : '',
			agility : '',
			armor : '',
			damage : ''
		};
		self.character = {
			id : '',
			name : null,
			level : '',
			experience : '',
			health : '',
			agility : '',
			armor : '',
			damage : ''
		};
		self.characters = [];

		self.monster = {
			id : '',
			name : null,
			level : '',
			experience : '',
			health : '',
			agility : '',
			armor : '',
			damage : ''
		};
		self.monsters = [];

		self.player = {
			id : '',
			name : null,
			level : '',
			experience : '',
			health : '',
			agility : '',
			armor : '',
			damage : ''
		};
		
		self.editedPlayer = {
				id : '',
				name : null,
				level : '',
				experience : '',
				health : '',
				agility : '',
				armor : '',
				damage : ''
			};
		

		self.fetchAllMonster = function() {
			RESTService.fetchAllMonster().then(function(d) {
				self.characters = d;
			}, function(errResponse) {
				console.error('Error while fetching Characters');
			});
		};

		self.featchPlayer = function() {
			RESTService.featchPlayer().then(function(d) {
				self.player = d;
			}, function(errResponse) {
				console.error('Error while fetching Characters');
			});
		};

		self.battle = function(id) {
			RESTService.battle(id).then(function(d) {
				self.displayWinner = d;
			}, function(errResponse) {
				console.error('Error while fetching Characters');
			});
		};

		self.editPlayer = function() {
			//console.log(this.self.player.id);
			self.editedPlayer.id = 0;
			RESTService.editPlayer(self.editedPlayer.id, self.editedPlayer).then(function(d) {
				self.player = d;
				self.featchPlayer();
			}, function(errResponse) {
				console.log("errResponse from controller:" + errResponse);
				console.error('Error while fetching Characters');
			});
		};
		
		self.deleteMonster = function(id) {
			RESTService.deleteMonster(id).then(function(d) {
				//self.monster = d;
				self.fetchAllMonster();
			}, function(errResponse) {
				console.log("errResponse from controller:" + errResponse);
				console.error('Error while fetching Characters');
			});
		};

		self.createMonster = function() {

			RESTService.createMonster(self.monster).then(function(d) {
				console.log("MONSTER IN CONTROLLER" + self.monster);
				self.monster = d;
				self.fetchAllMonster();
			}, function(errResponse) {
				console.log("errResponse from controller:" + errResponse);
				console.error('Error while fetching Characters');
			});
		};

		self.showPlayer = function() {
			self.myPlayer = !self.myPlayer;
			self.myBattle = false;
			self.myCreate = false;
			self.myMonster = false;

		};

		self.showBattle = function() {
			self.myBattle = !self.myBattle;
			self.myCreate = false;
			self.myMonster = false;
			self.myPlayer = false;
		};

		self.showMonster = function() {
			self.myMonster = !self.myMonster;
			self.myCreate = false;
			self.myBattle = false;
			self.myPlayer = false;
		};

		self.showCreate = function() {
			self.myCreate = !self.myCreate;
			self.myBattle = false;
			self.myPlayer = false;
			self.myMonster = false;
		};

		self.showEditPlayer = function() {
			self.myEditplayer = !self.myEditplayer;
			self.myBattle = false;
			self.myMonster = false;
		};





		self.fetchAllMonster();
		self.featchPlayer();

	} ]);