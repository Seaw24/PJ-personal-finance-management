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