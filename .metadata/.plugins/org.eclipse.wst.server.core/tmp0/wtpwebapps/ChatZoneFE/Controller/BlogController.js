app.controller('BlogController',['$scope','BlogService','CommentService','$location','$rootScope','$cookieStore','$http',
	function($scope, BlogService, CommentService, $location, $rootScope,$cookieStore, $http) {
	console.log("Inside blogController")
	this.blog={
		id : '',
		blogid : '',
		title : '',
		description : '',
		datetime : '',
		reason : '',
		status : ''
	}
	this.blogs=[];
	this.comments=[];
	
	this.createBlog = function(blog) {
		console.log("Inside createblog function of blogController");
		BlogService.createBlog(blog)
		.then(
				function(d) {
					$location.path("/blog")
				},
				function(errResponse) {
					console.error('Error while creating blog');
				});
	};
	this.create = function() {
		{
		console.log("Submit blog",this.blog);
		this.createBlog(this.blog);
		}
		
	
	};
	this.updateBlog = function(blog) {
		console.log("updateBlog!")
		this.blog.blogid=$rootScope.blog.blogid
		BlogService.updateBlog(blog)
		.then(
				function(d) 
				{
					this.blog=d;
					if(this.blog.errorcode==200)
					{
						alert("Thank You Blog Updated Successfully!!!")
						$location.path("/")
					}
					else if(this.blog.errorcode==400)
					{
						alert("User Not Logged In Please Log In First To Update Blog")
						$location.path("/login")
					}
					else if(this.blog.errorcode==404)
					{
						alert("Error Updating Blog Please Try Again")
						$location.path("/editBlog")
					}
					else if(this.blog.errorcode==500)
					{
						alert("This Blog Is Not Created By You So You Cannot Update This Blog")
						$location.path("/")
					}
					
				},
				function(errResponse) 
				{
						console.error('Error while updating Blog.');
			});
		};
	this.fetchBlogById = function(blog) {
		console.log("fetchBlogById!")
		BlogService.fetchBlogById(blog)
		.then(
				function(d) 
				{
					this.blog=d;
					$rootScope.blog=d;
					console.log(this.blog)
					alert("Thank You Blog Fetched Successfully!!!")
					$location.path("/displayBlogById")
				},
				function(errResponse) 
				{
						console.error('Error while fetching Blog.');
			});
		};

	
	this.fetchAllBlogs = function() {
		console.log("fetchAllBlogs!")
		BlogService.fetchAllBlogs()
		.then(
				function(d) 
				{
					this.blogs=d;
					if(this.blogs.length==0)
					{
						alert("There Are No Blogs To Display")
					}
					$rootScope.blogs=d;
					console.log(this.blogs)
					CommentService.fetchAllComments()
						.then(
								function(d){
									this.comments=d;
									$rootScope.comments=d;
								}
						);
					alert("Thank You Blogs Fetched Successfully!!!")
					$location.path('/displayBlog')
				},
				function(errResponse) 
				{
						console.error('Error while Fetching Blogs.');
			});
		};
		this.display = function() {
			{
				console.log('Display All Blog');
				this.fetchAllBlogs();
			}
		};

		
		this.deleteBlog = function(blog) {
			console.log("deleteBlog!")
			BlogService.deleteBlog(blog)
			.then(
					function(d) 
					{
						this.blog=d;
						if(this.blog.errorcode==200)
						{
							alert("Thank You Blog Deleted Successfully!!!")
						}
						else if(this.blog.errorcode==400)
						{
							alert("User Not Logged In Please Log In First To Delete Blog")
						}
						else if(this.blog.errorcode==404)
						{
							alert("No Such Blog Exists")
						}
						else if(this.blog.errorcode==500)
						{
							alert("This Blog Is Not Created By You So You Cannot Delete This Blog")
						}
						
					},
					function(errResponse)
					{
							console.error('Error while deleting Blog.');
				});
			};
	
	this.update = function(blog) {
			this.blog.blogid=blog;
			console.log('Update Blog', this.blog.blogid);
			BlogService.fetchBlogById(this.blog)
			.then(
				function(d) 
				{
					this.blog=d;
					$rootScope.blog=d;
					console.log(this.blog)
					$location.path('/editBlog')
				},
				function(errResponse) 
				{
						console.error('Error while Fetching Blogs.');
			});
		}
	this.edit = function(){
		this.blog.blogid=blog;
		console.log('Updating Blog', this.blog);
		this.updateBlog(this.blog)
	}
	this.displaybyid = function(blog) {
		{
			this.blog.blogid=blog;
			console.log('Display FetchBlogById',this.blog.blogid);
			console.log(this.blog);
			this.fetchBlogById(this.blog);
		}
	};
	this.remove = function(blog) {
		{
			this.blog.blogid=blog;
			console.log('Deleting Blog', this.blog.blogid);
			this.deleteBlog(this.blog.blogid);
		}
	};

			


	
	

	
	


	
	

}])
	