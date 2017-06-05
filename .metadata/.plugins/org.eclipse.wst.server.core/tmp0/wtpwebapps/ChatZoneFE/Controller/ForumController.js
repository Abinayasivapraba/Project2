
app.controller('ForumController',['$scope','ForumService','CommentService','$location','$rootScope','$cookieStore','$http',
	function($scope, ForumService, CommentService,$location, $rootScope,$cookieStore, $http) {
	console.log("Inside forumController")
	this.forum={
		id : '',
		forumid : '',
		forummessage : ''
	}
	this.forums=[];
	this.comments=[];
	this.createForum = function(forum) {
		console.log("Inside createforum function of forumController");
		ForumService.createForum(forum)
		.then(
				function(d) {
					$location.path("/createForum")
				},
				function(errResponse) {
					console.error('Error while creating forum');
				});
	};
	this.create = function() {
		{
		console.log("Submit forum",this.forum);
		this.createForum(this.forum);
		}
		
	
	};
	
	
	
	this.updateForum = function(forum) {
		console.log("updateforum!")
		this.forum.forumid=$rootScope.forum.forumid

		ForumService.updateForum(forum)
		.then(
				function(d) 
				{
					this.forum=d;
					if(this.forum.errorcode==200)
					{
						alert("Thank You forum Updated Successfully!!!")
						$location.path("/")
					}
					else if(this.forum.errorcode==400)
					{
						alert("User Not Logged In Please Log In First To Update forum")
						$location.path("/login")
					}
					else if(this.forum.errorcode==404)
					{
						alert("Error Updating Blog Please Try Again")
						$location.path("/editForum")
					}
					else if(this.forum.errorcode==500)
					{
						alert("This forum Is Not Created By You So You Cannot Update This forum")
						$location.path("/")
					}
					
				},
				function(errResponse) 
				{
						console.error('Error while updating forum.');
			});
		};
	
	this.update = function(forum) {
		
		console.log('Update forum', this.forum.forumid);
		this.forum.forumid=forum;
		ForumService.fetchForumById(this.forum)
		.then(
			function(d) 
			{
				this.forum=d;
				$rootScope.forum=d;
				console.log(this.forum)
				$location.path('/editForum')
			},
			function(errResponse) 
			{
					console.error('Error while Fetching forum.');
		});
	}
	
	
	
	
	
	
	
	
	
	this.edit = function(){
		this.forum.forumid=forum;
		console.log('Updating forum', this.forum);
		this.updateForum(this.forum)
	}
	
	
	
	
	
	
	
	
	this.fetchAllForums = function() {
		console.log("fetchAllForums!")
		ForumService.fetchAllForums()
		.then(
				function(d) 
				{
					this.forums=d;
					if(this.forums.length==0)
					{
						alert("There Are No Forums To Display")
					}
					$rootScope.forums=d;
					console.log(this.forums)
					CommentService.fetchAllComments()
					.then(
							function(d){
								this.comments=d;
								$rootScope.comments=d;
							}
					);
				alert("Thank You Forums Fetched Successfully!!!")
				$location.path('/displayForums')
			},
			function(errResponse) 
			{
					console.error('Error while Fetching Blogs.');
		});
	};
		this.display = function() {
			{
				console.log('Display All Forum');
				this.fetchAllForums();
			}
		};
		
		
	this.deleteForum = function(forum) {
		console.log("deleteForum!")
		ForumService.deleteForum(forum)
		
		.then(
				function(d) 
				{
					this.forum=d;
					if(this.forum.errorcode==200)
					{
						alert("Thank You forum Deleted Successfully!!!")
					}
					else if(this.forum.errorcode==400)
					{
						alert("User Not Logged In Please Log In First To Delete forum")
					}
					else if(this.forum.errorcode==404)
					{
						alert("No Such forum Exists")
					}
					else if(this.forum.errorcode==500)
					{
						alert("This forum Is Not Created By You So You Cannot Delete This forum")
					}
					
				},
				function(errResponse)
				{
						console.error('Error while deleting forum.');
			});
		};
		
		this.remove = function(forum) {
			{
				this.forum.forumid=forum;
				console.log('Deleting Forum', this.forum.forumid);
				this.deleteForum(this.forum.forumid);
			}
		};
		
		
		
			
	
	
	
	
	
}])
	