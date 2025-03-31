async function authUser() {
    const email = document.getElementById("user_email").value;
    const password = document.getElementById("user_password").value;

    if (!email || !password) {
        alert("Podaj email i hasło!");
        return;
    }

    try{
        const response = await fetch("http://localhost:8080/api/v1/auth/authenticate",{
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify({ email, password })
        });

        if (!response.ok) {
            throw new Error("Nieprawidłowy email lub hasło");
        }

        const data = await response.json();
        console.log("Zalogowano pomyślnie:", data);
    }catch (error){
        console.error("Błąd logowania:", error.message);
        alert("Błąd logowania: " + error.message);
    }
}


async function authUserTest() {

    try{
        const response = await fetch("http://localhost:8080/api/v1/user",{
            method: "GET",
            headers: {"Authorization": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJpZCI6IjEiLCJyb2xlIjoiQURNSU4iLCJlbWFpbCI6IktvbnJhZEB3cC5wbCIsImlhdCI6MTc0MjUwMzAwMSwiZXhwIjoxNzQyNTA2NjAxfQ.dhAEcUvPQ4Aw0PM9yDNigSe7HvzDqHnS8D8Z_PxFj9I"}
        });

        if (!response.ok) {
            throw new Error("Nieprawidłowy email lub hasło");
        }

        const data = await response.json();
        console.log("Zalogowano pomyślnie:", data);
    }catch (error){
        console.error("Błąd logowania:", error.message);
        alert("Błąd logowania: " + error.message);
    }
}