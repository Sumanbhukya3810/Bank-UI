document.addEventListener('DOMContentLoaded', function() {
    // Example: Add event listener to a button if needed
    const button = document.querySelector('#myButton');
    if (button) {
        button.addEventListener('click', function(event) {
            event.preventDefault();
            console.log('Button clicked');

            // Example: Fetch data from an API using AJAX
            fetch('https://api.example.com/data')
                .then(response => response.json())
                .then(data => {
                    console.log('Received data:', data);

                    // Example: Manipulate DOM based on received data
                    const resultContainer = document.querySelector('#resultContainer');
                    if (resultContainer) {
                        resultContainer.innerHTML = `<p>Data: ${data}</p>`;
                    }
                })
                .catch(error => console.error('Error fetching data:', error));
        });
    }

    // Example: Define and use a custom function
    function greet(name) {
        return `Hello, ${name}!`;
    }

    console.log(greet('World')); // Output: Hello, World!
});
