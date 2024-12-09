<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Details</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <h1>User Details</h1>
    
    <form id="userForm">
        <label for="userId">Enter User ID:</label>
        <input type="text" id="userId" name="id">
        <button type="submit">Get User Details</button>
    </form>
    
    <div id="userDetails">
        <!-- User details will be displayed here -->
    </div>
    
    <script>
        $(document).ready(function(){
            $('#userForm').on('submit', function(e){
                e.preventDefault();
                
                var userId = $('#userId').val();
                
                $.ajax({
                    url: '/UserDetailsAPI', // API servlet URL
                    type: 'GET',
                    data: { id: userId },
                    success: function(response) {
                        // Display the user details
                        if (response.error) {
                            $('#userDetails').html('<p>' + response.error + '</p>');
                        } else {
                            var userHtml = `
                                <p><strong>ID:</strong> ${response.id}</p>
                                <p><strong>Name:</strong> ${response.name}</p>
                                <p><strong>Username:</strong> ${response.username}</p>
                                <p><strong>Email:</strong> ${response.email}</p>
                                <p><strong>Course:</strong> ${response.course}</p>
                                <p><strong>Phone:</strong> ${response.phone}</p>
                                <p><strong>Address:</strong> ${response.current_address}</p>
                            `;
                            $('#userDetails').html(userHtml);
                        }
                    },
                    error: function(error) {
                        $('#userDetails').html('<p>Error fetching user details</p>');
                    }
                });
            });
        });
    </script>
</body>
</html>
