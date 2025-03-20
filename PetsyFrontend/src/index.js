async function authUser() {
    const email = document.getElementById("user_email").value;
    const password = document.getElementById("user_password").value;

    if (!email || !password) {
        alert("Podaj email i hasło!");
        return;
    }

    try{
        const response = await fetch("http://localhost:8080/user/auth",{
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