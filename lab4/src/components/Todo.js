import React from 'react'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faTrashAlt } from '@fortawesome/free-solid-svg-icons'

export const Todo = ({task, toggleComplete, deleteTodo}) => {
  return (
    <div className='Todo'>
        <div className='incompleted'>
        <p onClick={() => toggleComplete(task.id)}
         className= {`${task.completed ? 'completed' : ""}`}>
            {task.task}</p>
        </div>
        <div>

            <FontAwesomeIcon className='delete-icon' icon={faTrashAlt}
            onClick={() => deleteTodo(task.id)} />
        </div>
    </div>
  )
}

