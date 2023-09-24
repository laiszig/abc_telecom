import { Engineer } from "../roles/engineer";
import { PinCode } from "../pinCode/pincode";
import { Status } from "./status";

export class Ticket {
    id: number;
    // customer: Costumer;
    problemType: String;
    description: String;
    // feedback: Feedback;
    // manager: Manager;
    engineerAssigned: Engineer;
    pinCode: PinCode;
    status: Status;
}