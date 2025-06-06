import { twMerge } from "tailwind-merge"

type FilterProps = {

    setFilterOptions: Function,
    filterOptions: {
        name: string,
        checkbox: boolean
    }[]

}

export function Filter( props: FilterProps) {


    function modifyChecked ( index: number ) {
        
        props.setFilterOptions(props.filterOptions.map((option, i) =>
            i === index ? { ...option, checkbox: !option.checkbox } : option
        ))

    }

    return (

        <ul className="flex gap-6">
            {props.filterOptions.map((option, index) =>
                <li>
                    <button onClick={() => modifyChecked(index)} className={twMerge("w-full p-2 px-4 flex font-medium justify-between items-center rounded-md text-[1.1rem] font-Kanit text-center shadow-[0px_2px_1px_3px_rgba(0,0,0,0.2)]", option.checkbox ? "bg-[#D32F2F] text-[#FFF3E0] " : "bg-white hover:bg-[#D32F2F] hover:opacity-45 hover:text-white text-[#D32F2F]")}>
                        {option.name}
                    </button>
                </li>
            )}
        </ul>

    )
}