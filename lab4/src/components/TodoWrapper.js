import React, { useState, useEffect } from 'react'
import { TodoForm } from './TodoForm'
import {v4 as uuidv4} from 'uuid'
import { Todo } from './Todo';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faDownload, faMultiply, faUpload } from '@fortawesome/free-solid-svg-icons';
uuidv4();

export const TodoWrapper = () => {
    const [todos, setTodos] = useState(
        JSON.parse(localStorage.getItem('todos')) || []
        )

    const [showImporter, setShowImporter] = useState(false)

  useEffect(() => {
    localStorage.setItem('todos', JSON.stringify(todos));
  }, [todos]);
    

    const addTodo = todo => {
        setTodos([...todos, {id: uuidv4(), 
            task: todo,
            completed: false
        }])
        console.log(todos)
    }

    const toggleComplete = id => {
        setTodos(
            todos.map(todo => todo.id === id ? {...todo, completed: !todo.completed} : todo))
    }

    const deleteTodo = id => {
        setTodos(todos.filter(todo => todo.id !== id))
    }
    
    const toggleShowImporter = () => {
      setShowImporter(!showImporter);
    }

    const handleExport = () => {
        const dataStr = "data:text/json;charset=utf-8," + encodeURIComponent(JSON.stringify(todos));
        const downloadAnchorNode = document.createElement('a');
        downloadAnchorNode.setAttribute("href", dataStr);
        downloadAnchorNode.setAttribute("download", "todos.json");
        document.body.appendChild(downloadAnchorNode);
        downloadAnchorNode.click();
        downloadAnchorNode.remove();
      };
    
      const handleImport = (e) => {
        
        const reader = new FileReader();
        reader.onload = (e) => {
          if (e.target?.result) {
            setTodos(JSON.parse(e.target.result));
          }
        };
        if (e.target.files) {
          reader.readAsText(e.target.files[0]);
        }        
        toggleShowImporter();
      };
    

    

  return (
    <div className='TodoWrapper'>
        <h1>ZM's Delightful Task Planner!</h1>
        <div><TodoForm addTodo={addTodo} />
        {todos.map((todo,index) => 
            (<Todo task ={todo} 
            key={index} 
            toggleComplete={toggleComplete}
            deleteTodo={deleteTodo}
            />)
        )}
        </div>
        <div className='save-controls'>
        <FontAwesomeIcon className='export-icon' icon={faDownload}
          onClick={handleExport} />

        <FontAwesomeIcon className='import-icon' 
        icon={showImporter ? faMultiply : faUpload} 
        onClick={toggleShowImporter}/>

         <input className={showImporter ? '' : 'hide'}
         id="file-upload" 
         type="file" 
         accept=".json,application/json" 
         onChange={handleImport}/>
          
        </div>
    </div>
  )
}
