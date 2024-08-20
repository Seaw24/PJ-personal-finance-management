document.addEventListener('DOMContentLoaded', function() {
    const highlights = document.querySelectorAll('.highlight');
    
    highlights.forEach(highlight => {
        highlight.addEventListener('mouseover', function() {
            
            const img = this.querySelector('.gif');
            img.style.opacity = '1';
            img.style.zIndex = '1';
        });
        
        highlight.addEventListener('mouseout', function() {
            const img = this.querySelector('.gif');
            img.style.opacity = '0';
            img.style.zIndex = '-1';
        });
    });

    const loginForm = document.querySelectorAll('.saving .main__form');

    loginForm.forEach(form => {
        form.style.cursor = 'pointer';
        form.addEventListener('click', function() {
            this.submit();
            

        });
});
});

document.addEventListener('DOMContentLoaded', function() {
    const registerFormOpen = document.getElementById('Open__Register');
registerFormOpen.addEventListener('click', function() {
    const loginForm = document.querySelector('.login .main__section');
    loginForm.style.display = 'none';  // Hide the login form

    const registerForm = document.getElementById('Register__form');
    registerForm.style.visibility = 'visible';  // Move the register form into view
    
});

});



    
