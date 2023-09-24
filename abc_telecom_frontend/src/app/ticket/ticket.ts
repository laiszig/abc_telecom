import { Engineer } from "../roles/engineer";
import { PinCode } from "../pinCode/pincode";
import { Status } from "./status";
import { Manager } from "../roles/manager";

export class Ticket {
    id: number;
    // customer: Costumer;
    problemType: String;
    description: String;
    // feedback: Feedback;
    managerAssigned: Manager;
    engineerAssigned: Engineer;
    pinCode: PinCode;
    status: Status;
}