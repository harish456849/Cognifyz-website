import React, { useState, useEffect } from "react";

function TaskList() {
    const [tasks, setTasks] = useState([]);
    const [title, setTitle] = useState("");
    const [description, setDescription] = useState("");

    const token = localStorage.getItem("token");

    const fetchTasks = async () => {
        const response = await fetch("http://localhost:7070/api/tasks", {
            method: "GET",
            headers: { "Authorization": `Bearer ${token}` }
        });
        console.log(token);
        if (response.ok) {
            const data = await response.json();
            setTasks(data);
        }
    };

    useEffect(() => { fetchTasks(); }, []);

    const handleCreate = async (e) => {
        e.preventDefault();
        const response = await fetch("http://localhost:7070/api/tasks", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                "Authorization": `Bearer ${token}`
            },
            body: JSON.stringify({ title, description })
        });

        if (response.ok) {
            setTitle("");
            setDescription("");
            fetchTasks();
        }
    };

    return (
        <div className="container mt-4">
            <h3>My Tasks</h3>
            <form onSubmit={handleCreate} className="mb-4">
                <input 
                    type="text" 
                    className="form-control mb-2" 
                    placeholder="Title" 
                    value={title} 
                    onChange={(e) => setTitle(e.target.value)} 
                />
                <input 
                    type="text" 
                    className="form-control mb-2" 
                    placeholder="Description" 
                    value={description} 
                    onChange={(e) => setDescription(e.target.value)} 
                />
                <button type="submit" className="btn btn-primary">Add Task</button>
            </form>

            <ul className="list-group">
                {tasks.map((task) => (
                    <li key={task.id} className="list-group-item">
                        <strong>{task.title}</strong> - {task.description}
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default TaskList;