<!DOCTYPE html>
<html lang="en">
<head>
    <title>Casino Bar</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="../../resources/img/faviconUp.ico"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../../resources/css/bootstrapUp.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../../resources/css/font-awesomeUp.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../../resources/css/animateUp.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../../resources/css/hamburgersUp.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../../resources/css/select2Up.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../../resources/css/utilUp.css">
    <link rel="stylesheet" type="text/css" href="../../resources/css/mainUp.css">
    <!--===============================================================================================-->
</head>
<body>

<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100">
            <div class="login100-pic js-tilt" data-tilt>
                <img src="../../resources/img/img-01.png" alt="IMG">
            </div>

            <form method="post" class="login100-form validate-form">
					<span class="login100-form-title">
						Member SignUp
					</span>

                <div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
                    <input class="input100" type="text" name="name" placeholder="Email">
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
                </div>
                <div class="wrap-input100 validate-input" data-validate = "Valid age is required">
                    <input class="input100" type="text" name="age" placeholder="age">
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
                </div>

                <div class="wrap-input100 validate-input" data-validate = "Password is required">
                    <input class="input100" type="password" name="password" placeholder="Password">
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
                </div>

                <div class="container-login100-form-btn">
                    <button type="submit" class="login100-form-btn">
                        SignUp
                    </button>
                </div>

                <div class="text-center p-t-12">
						<span class="txt1">
							Forgot
						</span>
                    <a class="txt2" href="#">
                        Username / Password?
                    </a>
                </div>

                <div class="text-center p-t-136">
                    <a class="txt2" href="#">
                        Already have an Account? Login
                        <i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
                    </a>
                </div>
            </form>
        </div>
    </div>
</div>


<!--===============================================================================================-->
<script src="../../resources/js/jquery-3.2.1.minUp.js"></script>
<!--===============================================================================================-->
<script src="../../resources/js/popperUp.js"></script>
<script src="../../resources/js/bootstrapUp.min.js"></script>
<!--===============================================================================================-->
<script src="../../resources/js/select2Up.min.js"></script>
<!--===============================================================================================-->
<script src="../../resources/js/tilt.jquery.minUp.js"></script>
<script>
    $('.js-tilt').tilt({
        scale: 1.1
    })
</script>
<!--===============================================================================================-->
<script src="../../resources/js/mainUp.js"></script>

</body>
</html>