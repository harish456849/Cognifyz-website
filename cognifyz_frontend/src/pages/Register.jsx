export default function Register() {

    const handleSubmit = async (event) => {
        event.preventDefault();

        const response = await fetch(
            "http://localhost:7070/api/users",
            {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                BasicAuth: {
                  "username": "Harish123",
                  "password": "rai"
                },
                body: JSON.stringify({
                    name: "Harish",
                    email: "harish@gmail.com"
                })
            }
        );

        const data = await response.json();

        console.log(data);
    };

    return (
        <form onSubmit={handleSubmit}>
           
            <input
                type="text"
                placeholder="Name"
            />

            <input
                type="email"
                placeholder="Email"
            />

            <button type="submit">
                Register
            </button>

        </form>
    );
}