import React from 'react';

const DropDown = ({ marketsList, onMarketSelect }) => {
    const handleChange = (event) => {
        onMarketSelect(event.target.value);
    };

    return (
        <div>
            <select onChange={handleChange}>
                <option value="" disabled>Select a market</option>
                {marketsList.map((market, index) => (
                    <option key={index} value={market}>
                        {market}
                    </option>
                ))}
            </select>
        </div>
    );
};

export default DropDown;
