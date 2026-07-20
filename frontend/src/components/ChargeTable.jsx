function ChargeTable() {
  return (
    <div>
      <h2>Charge Breakdown</h2>

      <table border="1">
        <thead>
          <tr>
            <th>Charge</th>
            <th>Amount</th>
          </tr>
        </thead>

        <tbody>
          <tr>
            <td>Energy Charge</td>
            <td>₹2500</td>
          </tr>

          <tr>
            <td>Fixed Charge</td>
            <td>₹400</td>
          </tr>

          <tr>
            <td>Electricity Duty</td>
            <td>₹150</td>
          </tr>

          <tr>
            <td>Total</td>
            <td>₹3477.92</td>
          </tr>
        </tbody>
      </table>
    </div>
  );
}

export default ChargeTable;

